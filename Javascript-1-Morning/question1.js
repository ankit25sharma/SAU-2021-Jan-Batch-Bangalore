function prime_factors(num) {
    const result = [];
    for (let i = 2; i <= num; i++)
    {
      while (num % i === 0) 
      {
        if (!result.includes(i)) result.push(i);
        num /= i;
      }
    }
    if(num>2)
        result.push(num);
    return result;
  }
  console.log(prime_factors(100));  
  console.log(prime_factors(104));

  