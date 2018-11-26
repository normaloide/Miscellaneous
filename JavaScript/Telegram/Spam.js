/**
* Note that even if it's called "Spam.js", Telegram will automatically
* detect excessive spam and will block you for a n period of time.
* This program is in fact intended for automatization of messages that
* have to be sent every n time.
*/

var testoinizio = "init_text";  //this text will be executed once
var testo = "text";
var intervallo = 1;  //seconds
var volte = 100;
document.getElementsByClassName('composer_rich_textarea')[0].innerHTML = testoinizio;
$('.im_submit').trigger('mousedown'); 
var notifyInterval = 5;
var i = 0;
var timer = setInterval(function() {
document.getElementsByClassName('composer_rich_textarea')[0].innerHTML = testo;
$('.im_submit').trigger('mousedown'); 
i++;
if (i == volte)
clearInterval(timer);
if (i % notifyInterval == 0)
console.log(i + ' MESSAGES SENT');
} , intervallo * 1000);
