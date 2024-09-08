const dateNow = new Date();
const year = dateNow.getFullYear();
const month = ("0" + (dateNow.getMonth() + 1)).slice(-2);
const date = ("0" + dateNow.getDate()).slice(-2);

document.getElementById("inputDate").min = year + "-" + month + "-" + date;

document.getElementById("inputDate").max = year + "-" + month + "-" + 31;
