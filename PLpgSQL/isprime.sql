CREATE FUNCTION isprime(n INT)
RETURNS VOID AS $$

DECLARE
  i INT := 2;

BEGIN
  IF n < 2 THEN
    RAISE NOTICE 'not prime';
  END IF;

  LOOP
    IF n % i = 0 THEN
      RAISE NOTICE 'not prime';
      EXIT;
    END IF;

    IF  i > floor(sqrt(n)) THEN
      RAISE NOTICE 'prime';
      EXIT;
    END IF;

    i := i + 1;
  END LOOP;
END;
$$ LANGUAGE plpgsql;
