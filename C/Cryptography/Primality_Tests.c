#include <stdio.h>
#include <gmp.h>

//Fermat_Single_Base
int fermat_single_base(mpz_t n, mpz_t a) {
	mpz_t nmu, val1, val2;
	mpz_inits(nmu, val1, val2, NULL);
	mpz_sub_ui(nmu, n, 1);
	mpz_powm(val2, a, nmu, n);
	mpz_mod_ui(val1, n, 2);
	
	if(mpz_cmp_ui(val1, 0) == 0) {
		return 0;
	}
	
	if(mpz_cmp_ui(val2, 1) == 0) {
		return 1;
	}
	
	else {
		return 0;
	}
}

//complete Fermat
int test_fermat(mpz_t n) {
	
	//initialize
	int count = 2;
	mpz_t i, nmu;
	mpz_inits(i, nmu);
	mpz_sub_ui(nmu, n, 1);
	mpz_set_str(i, "2", 10);
	
	//exclude 2
	if(mpz_cmp_ui(n, 2) == 0) {
		return 1;
	}
	
	//from 2 to 302
	while(count < 303) {
		
		//a < p-1
		if(mpz_cmp(i, nmu) == 0) {
			break;
		}
		
		if(fermat_single_base(n, i) != 1) {
			return 0;
		}
		
		mpz_add_ui(i, i, 1);
		count++;
	}
	
	return 1;
}

int main() {
	
	//initializing
	mpz_t p;
	mpz_init(p);
	
	printf("\n");
	for(int i = 0; i < 19; i++) {
		printf("*");
	}
	
	printf("\n0 NOT PRIME\n1 POSSIBLE PRIME\n2 SURELY PRIME\n");
	
	for(int i = 0; i < 19; i++) {
		printf("*");
	}
	
	printf("\nNumber chosen: ");
	gmp_scanf("%Zd", p);
	printf("\n");
	int x;
	
	//Miller-Rabin 4^(-1mln) precision
	x = mpz_probab_prime_p(p, 1000000);
	
	printf("\nMiller-Rabin:\n%d\n", x);

	//complete Fermat
	x = test_fermat(p);
	
	printf("\nFermat:\n%d\n\n", x);
	mpz_clear(p);
	return 0;
}
