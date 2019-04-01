a = IO.gets("Insert number: ") |> String.trim_trailing()
a = String.to_integer(a, 2)

IO.puts("From Decimal to Binary: #{a}")
