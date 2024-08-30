function mostra1(){
    let num = (Math.random()*100).toFixed();
    console.log(num);
    return function (valor){
        console.log(valor);
        return function(valor2 , valor3){
            let soma = valor2+valor3;
            return soma;
        };
    };
}

console.log(mostra1()(10)(10,40));

