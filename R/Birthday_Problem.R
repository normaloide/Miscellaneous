# import library(ggplot2) and library(tidyverse) for a better view of the graph

dev.new()
ppl = 100                     # people
v <- numeric(ppl)             # vector to cast probabilities (as much as people count)
for(i in 1:ppl) {             
  x <- 1 - (0:(i - 1))/365    # in the argument x I'll store the probabilities from 0 to i-1
  v[i] <- 1 - prod(x)         # at i, v will cast the product of all the arguments in x
}

s <- seq(0, 1, by = 0.1)
list <- as.data.frame(v)

png("bp.png", width = 600, height = 350)
plot(v, xlab ="Number of People", ylab = "Probability", col="black")
dev.off()
