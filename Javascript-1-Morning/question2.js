function toggleCase(input) {
    let res = "";
    for(let i=0;i<input.length;i++)
    {
        if(input[i]>='A' && input[i]<='Z')
            res=res+(input[i].toLowerCase());

        if(input[i]>='a' && input[i]<='z')
        res=res+(input[i].toUpperCase());
    }
    console.log(res);
}

toggleCase("Ankit");