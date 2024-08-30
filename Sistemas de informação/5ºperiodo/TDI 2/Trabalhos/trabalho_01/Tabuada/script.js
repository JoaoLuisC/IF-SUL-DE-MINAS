function multiplicar() {
    var num1 = document.getElementById('txt-numero');
    var res = document.getElementById('lista');
    if (num1.value.length == 0) {
        res.innerHTML = '<option>Impossível calcular, digite um número</option>';
    } else {
        var n1 = Number(num1.value);
        res.innerHTML = "";
        for (var c = 1; c <= 10; c++) {
            var item = document.createElement('option');
            item.text = `${n1} x ${c} = ${n1 * c}`;
            item.value = `tab${c}`;
            res.appendChild(item);
        }
    }
}

function finalizar() {
    multiplicar();
}

function zerarDados() {
    document.getElementById('txt-numero').value = "";
    document.getElementById('lista').innerHTML = "";
    document.getElementById('msg').innerHTML = '<p>Digite um Número</p>';
}
