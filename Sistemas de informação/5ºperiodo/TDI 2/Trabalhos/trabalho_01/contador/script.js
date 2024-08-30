function gerarContagem(){
    var inicio = document.getElementById('numero-inicial');
    var fim = document.getElementById('numero-final');
    var passos = document.getElementById('numero-passos');
    var resultado = document.getElementById('resultado');

    if(inicio.value.length == 0 || fim.value.length == 0 || passos.value.length == 0){
        resultado.innerHTML = ('Impossível contar');
    }else{
        resultado.innerHTML = ''; // Limpar qualquer conteúdo anterior

        var inicioNum = Number(inicio.value);
        var fimNum = Number(fim.value);
        var passosNum = Number(passos.value);

        if(passosNum <= 0){
            alert('Intervalo inválido, considerando como 1');
            passosNum = 1;
        }

        if(inicioNum < fimNum){
            // contagem crescente
            for(var contador = inicioNum; contador <= fimNum; contador += passosNum){
                var option = document.createElement('option');
                option.text = contador;
                resultado.add(option);
            }
        }else {
            // contagem regressiva
            for(var contador = inicioNum; contador >= fimNum; contador -= passosNum){
                var option = document.createElement('option');
                option.text = contador;
                resultado.add(option);
            }
        }
    }
}

function zerarDados(){
    document.getElementById('numero-inicial').value = ''
    document.getElementById('numero-final').value = ''
    document.getElementById('numero-passos').value = ''
    document.getElementById('resultado').innerHTML = ''
}