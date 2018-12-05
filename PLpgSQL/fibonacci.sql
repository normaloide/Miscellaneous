CREATE FUNCTION fibonacci(max INT)
RETURNS VOID AS $$

DECLARE
  a INT := 1;
  b INT := 1;
  tmp INT;
  i INT := 1;

BEGIN
  RAISE NOTICE '[1] %', a;
  RAISE NOTICE '[2] %', b;

  WHILE i < max LOOP
    tmp := a + b;
    a := b;
    b := tmp;
    i := i + 1;
    RAISE NOTICE '[%] %', i, tmp;
  END LOOP;
END;
$$ LANGUAGE plpgsql;
