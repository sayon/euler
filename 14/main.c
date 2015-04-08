#include <stdio.h>

uint32_t cache[1000000] = {0};

int main() {

    uint32_t num;
    uint32_t longest_length = 0;
    uint32_t longest_length_idx = 0;

    for( num = 1; num <= 1000000; num++ ) {
        uint32_t i = num;
        uint32_t current_length = 1;
        while(i > 1)  {
            if (i < num) { current_length += cache[i]; break; }
            if (i % 2)  i = i * 3 + 1;
            else i /= 2; 
            current_length ++;
        }
        cache[num] = current_length;
        if (longest_length < current_length) { longest_length = current_length; longest_length_idx = num; }
    }

    printf("longest length given by %zu : %zu\n", longest_length_idx, longest_length );

}
