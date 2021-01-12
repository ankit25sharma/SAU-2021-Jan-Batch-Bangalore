function checkNum(input) {
    let res = true;
    let temp=input%10;
    input=Math.floor(input/10);
    while(input>0)
    {
        if(temp !== input%10)
            res = false;
        input=Math.floor(input/10);
    }
    console.log(res);
}

console.log(checkNum(1111));