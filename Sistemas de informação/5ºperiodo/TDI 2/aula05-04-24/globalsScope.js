//GLOBAL SCOPE
// const nome = "Joao";
// let idade = 22;
// var filhos = 32;


function printData(){
    console.log(`Nome ${nome}, Idade ${idade}, Numero de Filhos ${filhos}`);
    idade = 23;

    for (var i = 0; i <=9; i++) {
        console.log(i);    
    }
    console.log(i);    

}

printData();
console.log(`Nome ${nome}, Idade ${idade}, Numero de  ${filhos}`);

//Var não respeita escopo de Bloco
console.log("---------------------------------------------------");

// REDECLARAÇÃO

// Da erros pois n pode redefinir usando o msm nome
// let filhos = 1;
// const filhos = 1;
// O var n se importa e pode ser usado para isso 
// var filhos = 1; 

console.log(filhos);

// let nome;
// let idade;

function globalAuto(){
    nome = "Emerson";
    //Atribuição SEM declaração, vai automaticamente para todo o escopo global
    idade = 42;
}

globalAuto();

// console.log(`Nome ${nome}, Idade ${idade}`)


function scopeTest(){
    const marca = "volvo";
    let modelo = "CX40";
    //Atribuição sem declaração
    ano = "2024";
    console.log(`Marca ${marca}, modelo ${modelo}, ano ${ano}`);
    // Mesmo Declarando depois por um processo de hosting o js leva a declaração ao topo do escopo, apenas acontece com o var isso
    //lOGO ANO n é mais visto em escopo Global
    var ano;
}

scopeTest();

console.log(`Marca ${marca}, modelo ${modelo}, ano ${ano}`);