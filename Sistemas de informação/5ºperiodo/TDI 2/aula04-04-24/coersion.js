//Tipos Primitivos
// const nome = "Joao";
// const altura = 1.70;
// const hab = true;

// console.log(`[Tipo nome: ${typeof nome}], [Tipo altura: ${typeof altura}], [Tipo hab: ${typeof hab}]`);

// console.log(`Nome ${nome.toUpperCase()}, altura ${altura}, habiitação ${hab.toString().toUpperCase()}`);

String.prototype.metodoQualquer = function(){ //Adicionando um metodo a 
    return this;
}

const nome = "Joao";
console.log(typeof nome); //String
console.log(nome.metodoQualquer()); //Coersão aqui
let copiaDoNome = nome.metodoQualquer();//Coersão aqui
console.log(typeof copiaDoNome);


