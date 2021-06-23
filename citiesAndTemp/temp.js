var input = "Albany|22.2*Caribou|9.5*Columbia|44.6*Denver|29.2*Indianapolis|26.5*Montgomery|46.6*San Diego|57.8*Tulsa|36.4*Tampa|61.3*Billings|24.0"
var cities = input.split('*');


var cold = [];
var moderate = [];
var hot = [];



for (i = 0; i <= cities.length - 1; i++){
  var temp = cities[i].split('|')
  
  var result = (temp[1] - 32) * (9/5)
  if(result < 20)
    cold.push(cities[i]+ "|celsius = " + result)
  else if(result > 20 && result < 30)
    moderate.push(cities[i]+ "|celsius = " + result)
  else if(result > 30)
    hot.push(cities[i]+ "|celsius = " + result)
}
console.log("Cold Cities: ")
console.log(cold)
console.log("Moderate Cities: " )
console.log(moderate)
console.log("Hot Cities: " );
console.log(hot)




