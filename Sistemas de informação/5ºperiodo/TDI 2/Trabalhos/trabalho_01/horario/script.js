function updateClock() {
    var body = document.body;
    var now = new Date();
    var hours = now.getHours();
    var minutes = now.getMinutes();
    var seconds = now.getSeconds();

    hours = hours < 10 ? "0" + hours : hours;
    minutes = minutes < 10 ? "0" + minutes : minutes;
    seconds = seconds < 10 ? "0" + seconds : seconds;

    document.getElementById('msg').textContent = "Agora são " + hours + ":" + minutes + ":" + seconds;

    if (hours >= 0 && hours < 8) {
        document.getElementById('image').style.backgroundImage = "url('./assets/foto_manha.jpg')";
    } else if (hours >= 8 && hours < 14) {
        document.getElementById('image').style.backgroundImage = "url('./assets/foto_dia.jpg')";
    } else if (hours >= 14 && hours < 19) {
        document.getElementById('image').style.backgroundImage = "url('./assets/foto_tarde.jpg')";
    } else if (hours >= 19 && hours < 24) {
        document.getElementById('image').style.backgroundImage = "url('./assets/foto_noite.jpg')";
    }
}

setInterval(updateClock, 1000);
