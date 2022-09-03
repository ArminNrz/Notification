let stompClient = null;

$(document).ready(function () {
   console.log("Index page is ready");
   connect();
});

function connect() {
    const socket = new SockJS("/ronad-notification-ws");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
       console.log("Connected: " + frame);
       stompClient.subscribe('/event/notification', function (message) {
          showMessage(JSON.parse(message.body).content);
          sendMessage(); // send token
       });
       stompClient.subscribe('/event/notificationData', function (message) {
          showMessage(JSON.parse(message.body).content); // listen to this to received notification DTO
       });
    });
}

function showMessage(message) {
   $("#messages").append('<tr><td>' + message + '</td></tr>');
}

function sendMessage() {
   console.log("sending message");
   stompClient.send("/notification-service/token-received", {}, JSON.stringify({'messageContent' : $("#message").val()}));
}