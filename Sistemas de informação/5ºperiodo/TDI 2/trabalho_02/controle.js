//alert(parseInt(Math.random() * 10000));
const form = document.getElementById("form");
const descriptionImput = document.getElementById("descricao");
//Como funciona o query selector - ele pega o elemento pelo DOOM 
const valueImput = document.querySelector("#montante");
const balanceH1 = document.getElementById("balanco");


//Terá outrass coisas

form.addEventListener("submit", event => {
    event.preventDefault();

    const descriptionTransation = descriptionImput.value.trim();
    const valueTransation = valueImput.value.trim();

    if (descriptionTransation == "") {
        alert("Informe a descrição");
        descriptionImput.focus();
        return;
    }
    if (valueTransation == "") {
        alert("Informe o valor");
        valueImput.focus();
        return;
    }

    const transation = {
        id: parseInt
    }

    descriptionTransation.value = "";
    valueTransation.value = "";

});


function balanceSum(transation) {


    //recuperar o elemento
    let balanceValue = balanceH1.innerHTML.trim();
    //pegar o valor e remover o cifrao
    balanceValue  = balanceValue.replace("R$", "");
    balanceValue.parseFloat(balanceValue);


    alert("")
}