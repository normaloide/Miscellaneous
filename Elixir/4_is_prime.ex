p = IO.gets("Let's check if your number is prime: ") |> String.trim_trailing()
p = String.to_integer(p)

if p > 1 do
	for n <- 2..Kernel.trunc(:math.ceil(:math.sqrt(p))) do
		if rem(p, n) === 0 do
			IO.puts("#{p} is not prime")
			exit(:shutdown)
		end
	end

	IO.puts("#{p} is prime")
else
	IO.puts("#{p} is not prime")
end
