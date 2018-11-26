var testoinizio = "init";
var testone = "Numero ";
var intervallo = 1;
var volte = 10;
var i = 0;
var testo = volte;
document.getElementsByClassName('composer_rich_textarea')[0].innerHTML = testoinizio;
$('.im_submit').trigger('mousedown'); 
var notifyInterval = 5;
var timer = setInterval(function() {
document.getElementsByClassName('composer_rich_textarea')[0].innerHTML = testone + (testo - i).toString();
$('.im_submit').trigger('mousedown'); 
i++;
if (i == volte)
clearInterval(timer);
if (i % notifyInterval == 0)
console.log(i + ' MESSAGES SENT');
} , intervallo * 1000);
