let entrada1;
let entrada2 = undefined;
let entrada3 = null;


console.log(entrada1);
console.log(entrada2);
console.log(entrada3);

console.log(typeof entrada1);
console.log(typeof entrada2);
console.log(typeof entrada3); // um bug da linguagem pois é retornado um object e n um null;


let nula = null;
let indefinida = undefined;

console.log(nula == indefinida) //true;
console.log(nula === indefinida)//false pois o typeof é diferente de cada uma;

console.log(nula ? 'verdadeira' : 'falsa');

console.log(2+ indefinida);//Nan
console.log(2 + nula);//2, pois 2 + nuda é 2
