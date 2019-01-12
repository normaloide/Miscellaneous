library(gmp)
library(ggplot2)
library(tidyverse)

t <- isprime(1:10000000, reps = 40)
Primes <- (1:10000000)[t > 0]
Number_of_Primes <- (1:length(Primes))
list <- as.data.frame(Primes)

ggplot(list, aes(x = Primes, y = Number_of_Primes)) + geom_bin2d(bins = 71)
