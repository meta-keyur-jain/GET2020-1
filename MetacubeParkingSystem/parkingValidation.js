class Parking {
    constructor() {}
    static validationForUser(name, email, contact) {
        var count = 0;
        var filterName = new RegExp('\\d');
        if (name.length <= 2) {
            this.invalidData('invalidName');
            this.invalidDescription('invalidName', "Insert name greater than 2 character");
            count--;
        } else if (filterName.test(name)) {
            this.invalidData('invalidName');
            this.invalidDescription('invalidName', "Numeric value not allowed");
            count--;
        } else {
            this.removeDescription('invalidName', "");
            count++;
        }

        var filterEmail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        if (email == "") {
            this.invalidData('invalidEmail');
            this.invalidDescription('invalidEmail', "Insert a email id");
            count--;
        }
        if (!filterEmail.test(email)) {
            this.invalidData('invalidEmail');
            this.invalidDescription('invalidEmail', "Insert a Valid Email");
            count--;
        } else {
            this.removeDescription('invalidEmail', "");
            count++;
        }
        var filterContact = new RegExp('([a-zA-Z!@#$%^&*()_+])');

        if (!(contact.length <= 10 && contact.length >= 8)) {
            this.invalidData('invalidContact')
            this.invalidDescription('invalidContact', "Insert Number Between 8 to 10");
            count--;
        } else if (filterContact.test(contact)) {
            this.invalidData('invalidContact')
            this.invalidDescription('invalidContact', "Numeric value only allowed");
            count--;
        } else {
            this.removeDescription('invalidContact', "");
            count++;
        }
        return count;
    }
    static validationForVehicle(vName, type, vehicleNum, identity) {
        var count = 0;
        if (vName.length <= 2) {
            this.invalidData('invalidVehicleName');
            this.invalidDescription('invalidVehicleName', "Insert name greater then 2 word");
            count--;
        } else {
            this.removeDescription('invalidVehicleName', "");
            count++;
        }
        if (type == "none") {
            this.invalidData('invalidType');
            this.invalidDescription('invalidType', "Select Type Of Your Vehicle");
            count--;
        } else {
            this.removeDescription('invalidType', "");
            count++;
        }
        if (vehicleNum.length <= 4) {
            this.invalidData('invalidVehicleNumber');
            this.invalidDescription('invalidVehicleNumber', "Vehicle Number required");
            count--;
        } else {
            this.removeDescription('invalidVehicleNumber', "");
            count++;
        }
        if (identity.length <= 8) {
            this.invalidData('invalidIdentity');
            this.invalidDescription('invalidIdentity', "Identity filled is required");
            count--;
        } else {
            this.removeDescription('invalidIdentity', "");
            count++;
        }
        return count;
    }

    static showTotalMoney(price, divId) {
        this.collapseDiv(divId);
        document.getElementById("totalAmount").innerHTML = "Total Amount is :- " + price + "$";
    }

    static invalidData(id) {
        document.getElementById(id).style.color = "red";
    }
    static invalidDescription(id, text) {
        var value = document.getElementById(id).innerHTML = text;
    }
    static removeDescription(id, text) {
        var value = document.getElementById(id).innerHTML = text;
    }
    static collapseDiv(id) {
        document.getElementById(id).style.display = 'none';
    }

    static viewDiv(id) {
        document.getElementById(id).style.display = 'block';
    }
    static insertReadonlyvalue(id, text) {
        document.getElementById(id).value = text;
    }
}

function checkPasswordValidation() {
    var password = document.getElementById('Password').value;
    var confirmPassword = document.getElementById('ConfirmPassword').value;
    var filterPassword = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
    if (password.length <= 8 || !filterPassword.test(password)) {
        document.getElementById('invalidPassword').style.color = 'red';
        document.getElementById('invalidPassword').innerHTML = 'Contains Uppercase, Lowercase Numeric, Alphanumeric, 8 character';
        document.getElementById("Submit").disabled = true;
    } else {
        document.getElementById('invalidPassword').innerHTML = '';
        document.getElementById("Submit").disabled = false;
    }
}

function checkPasswordEqual() {
    var password = document.getElementById('Password').value;
    var confirmPassword = document.getElementById('ConfirmPassword').value;
    var filterPassword = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
    if (password.length >= 8 || filterPassword.test(password)) {
        if (password == confirmPassword) {
            document.getElementById("ConfirmPassword").style.borderColor = "#ccc";
            document.getElementById("Submit").disabled = false;
        } else {
            document.getElementById("ConfirmPassword").style.outline = "none";
            document.getElementById("ConfirmPassword").style.borderColor = "red";
            document.getElementById("Submit").disabled = true;
        }
    }
}

function employeeRegistration() {
    var name = document.getElementById("FullName").value;
    var email = document.getElementById("Email").value;
    var contact = document.getElementById("Contact").value;
    var validUser = Parking.validationForUser(name, email, contact);
    if (validUser == 3) {
        var employeeId = document.getElementById("Contact").value * 2;
        Parking.collapseDiv('add-employee');
        Parking.viewDiv("employee-registered-message");
        document.getElementById('registered').innerHTML = "Registered successful with Employee Id : " + employeeId;
        Parking.insertReadonlyvalue('EmployeeId', employeeId);
        Parking.viewDiv('add-vehicle-form');
    }
}

function vehicleRegister() {
    var vName = document.getElementById("VehicleName").value;
    var type = document.getElementById("Type").value;
    var vehicleNum = document.getElementById("VehicleNumber").value;
    var identity = document.getElementById("Identification").value;
    var count = Parking.validationForVehicle(vName, type, vehicleNum, identity);
    if (count == 4) {
        alert("Your Vehicle is Register");
        Parking.collapseDiv('add-vehicle-form');
        Parking.collapseDiv("employee-registered-message");
        Parking.viewDiv('vehicle-Price-div');
        Parking.viewDiv('price-content-type');
        Parking.viewDiv(type);
        Parking.viewDiv('button');
    }
}

function changeCurrency() {
    var sign = document.getElementsByClassName('sign');
    for (var i = 0; i < sign.length; i++) {
        sign[i].innerText = document.getElementById('price').value
    }
    var type = document.getElementById("Type").value;
    var money = document.getElementById(type).querySelectorAll('.money');
    var x = document.getElementById(type).querySelectorAll(".p");
    switch (document.getElementById('price').value) {
        case "USD":
            for (var i = 0; i < money.length; i++) {
                money[i].innerText = x[i].value;
            }
            break;
        case "YEN":
            for (var i = 0; i < money.length; i++) {
                money[i].innerText = x[i].value * 1.52
            }
            break;
        case "INR":
            for (var i = 0; i < money.length; i++) {
                money[i].innerText = x[i].value * 71.1095;
            }
            break;
    }
}

function takeGetPass() {
    var checkvlaueSelect = 0;
    var type = document.getElementById("Type").value;
    var x = document.getElementById(type).querySelectorAll(".p");
    for (var i = 0; i < x.length; i++) {
        if (x[i].checked == true) {
            checkvlaueSelect = 1;
            Parking.showTotalMoney(x[i].value, "vehicle-Price-div");
        }
    }
    if (checkvlaueSelect == 0) {
        document.getElementById("error-message").innerHTML = "Select Price";
    }
}