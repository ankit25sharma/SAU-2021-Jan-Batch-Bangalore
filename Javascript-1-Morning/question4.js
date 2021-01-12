function digitSum(input) {
    let res = 0;
    while(input>0)
    {
        res+=input%10;
        input=Math.floor(input/10);
    }
    console.log(res);
}

console.log(digitSum("1111"));