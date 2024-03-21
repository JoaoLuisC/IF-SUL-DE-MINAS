function f5() {
    console.log(`f5() rodou`);
}

function f4() {
    setTimeout(f5,5000);
    console.log(`f4() rodou`);
}
function f3() {
    console.log(`f3() rodou`);
    f4();
}
function f2() {
    console.log(`f2() rodou`);
    setTimeout(f3,1000);
}
function f1() {
    console.log(`f1() rodou`);
    f2();
}

f1();

let value = Math.random(100);
while(value > 10){
    
}

console.log("termino")
