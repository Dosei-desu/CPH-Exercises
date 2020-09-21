int sum = 0;
for(int count = 0; count < 1000; count++){
  if(count % 3 == 0 || count % 5 == 0){
    sum += count;
  }
}
println(sum);
