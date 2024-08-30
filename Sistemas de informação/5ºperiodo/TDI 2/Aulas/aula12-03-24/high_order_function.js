function maioQue(){
    let num = (Math.random() *100).toFixed();
    console.log("Randon: ");
    console.log(num);
    return function(valor){
        return valor > num;
    }
}

console.log(maioQue()(50));

//Usando uma variavel Intermediaria
const funcRef = maioQue();
console.log(funcRef(10));
console.log(maioQue()(20));
