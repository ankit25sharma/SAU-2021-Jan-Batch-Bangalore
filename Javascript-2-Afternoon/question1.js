class input {
    constructor(param) {
        this.input = param;
    }
    calculateLength() {
        return this.input.length;
    };
    getUpperCase() {
        return this.input.toUpperCase();
    };
    getLowerCase() {
        return this.input.toLowerCase();
    };
    getVowelAndConst() {
        let temp = this.input;
        temp = temp.toLowerCase();
        temp = temp.split("");
        let vowres = "";
        let conres = "";
        let numbers = "";
        const vowels =['a', 'e', 'i', 'o', 'u'];
        const nums = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '0'];
        for(let i in temp)
        {
            if(vowels.includes(temp[i]))
                vowres = vowres+temp[i]+" ";
            else if(nums.includes(temp[i]))
                numbers =numbers+temp[i];
            else
                conres = conres + temp[i] +" ";
        }
        document.getElementById("vow").innerHTML = vowres;
        document.getElementById("con").innerHTML = conres;
    };
    getValidInput() {
        let temp = this.input;
        let check = false;
        const nums = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '0'];
        try {
            for(let i in temp)
            {
                if(nums.includes(temp[i])){
                    check = true;
                    throw new Error("Your string contains number");
                }
            }

        }
        catch(e) {
            console.error(e.name + ": " + e.message);
        }
        finally {
            if(check) 
                document.getElementById("num").innerHTML = "Contains number";
            else
            document.getElementById("num").innerHTML = "Do not contains number";
        }
    };
}

function callFunction() {
    var inputValue = document.getElementById("inputTxt").value;
    let inputObject = new input(inputValue);
    document.getElementById("lengthOp").innerHTML = inputObject.calculateLength();
    document.getElementById("ucOp").innerHTML = inputObject.getUpperCase();
    document.getElementById("lcOp").innerHTML = inputObject.getLowerCase();
    inputObject.getVowelAndConst();
    inputObject.getValidInput();
}