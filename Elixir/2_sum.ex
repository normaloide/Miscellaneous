a = IO.gets("Insert the first number: ") |> String.trim_trailing
a = String.to_integer(a)
b = IO.gets("Insert the second number: ") |> String.trim_trailing
b = String.to_integer(b)
c = a + b

IO.puts("Sum: #{c}")
