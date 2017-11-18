var send = document.getElementById("send");
send.addEventListener(click, function () {
    var role = document.getElementsByName("role");
    if (role == "company") {
        console.log(role);
    }
    if (role == "jobseeker") {
        console.log(role)
    }
});
