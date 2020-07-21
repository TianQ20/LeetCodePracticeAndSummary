# Base N bitwise conclution

## Base 7

* using a stringbuilder to append the remainder each time, then reverse it can get the result.

* becareful with the edge case like `0` and `negative number`.

```java
class Solution_1 {
        public String convertToBase7(int num) {
            if (num == 0) return "0";
            int r;
            StringBuilder sb = new StringBuilder();
            boolean negative = false;
            if (num < 0) negative = true;

            while (num != 0) {
                r = num % 7;
                sb.append(Math.abs(r));
                num /= 7;
            }

            if (negative) {
                sb.append('-');
            }
            return sb.reverse().toString();
        }
    }

```

* To be more concise:

```java
class Solution_2 {
        public String convertToBase7(int num) {
            if (num < 0) return "-" + convertToBase7(-num);
            if (num < 7) return Integer.toString(num);
            return convertToBase7(num / 7) + convertToBase7(num % 7);
        }
    }

```

## Convert to Base -2

### solution 1

```java
class Solution {
    public String baseNeg2(int N) {
        if (N == 0) return "0";

        String ans = "";
        while (N != 0) {
            int remainder = N % (-2);
            N /= -2;

            if (remainder < 0) { // avoid negative remainder
                remainder += Math.asb(-2);
                N += 1;
            }
            ans = String.valueOf(remainder) + ans;
        }
        return ans;
    }
}
```

### solution 2

* now we need to deal with the negative number, we can not simply append a `-` in front of the reversed stringbuilder.

* think about base 2:
    `1, 2, 4, 8...`
    we use `N = N >> 1`
    so for base -2 :
    `1, -2, 4, -8...`
    we should use: `N = - (N >> 1)`

```java
class Solution {
        public String baseNeg2(int N) {
            if (N == 0) return "0";
            StringBuilder sb = new StringBuilder();
            while (N != 0) {
                // 0001 & with any number will just return the least significant bit
                sb.append(N & 1);
                /**
                 * -3 in 8-bit is 11111101 and -3>>1 is 11111110, which is -2
                 * this is different from -3/2, which is -1
                 */
                N = - (N >> 1);
            }
            return sb.reverse().toString();
        }
    }
```

### general template for convert positive base

* negative base can removed three line about num < 0

* use `base`

```java
class Solution {
    public String convertToBase(int num) {
        if (num == 0) return "0";
        String ans = "";
        if (num < 0) {
            return "-" + convert(-num);
        }
        return convert(num);
    }

    private String convert(int num) {
        String ans = "";
        while (num != 0) {
            int remainder = num % base;
            num /= base;

            if (remainder < 0) {
                remainder += Math.abs(num);
                num += 1;
            }
            ans = String.valueOf(remainder) + ans;
        }
        return ans;
    }
}

```

## Adding Two Negabinary Numbers

* similar to convert into base -2

```java
class Solution {
        public int[] addNegabinary(int[] arr1, int[] arr2) {
            int i = arr1.length - 1;
            int j = arr2.length - 1;
            int carry = 0;
            Stack<Integer> stack = new Stack<>();

            while (i >= 0 || j >= 0 || carry != 0) {
                if (i >= 0) carry += arr1[i--];
                if (j >= 0) carry += arr2[j--];
                stack.push(carry & 1); // push the least significant bit
                carry = - (carry >> 1);
            }

            while (!stack.isEmpty() && stack.peek() == 0) {
                stack.pop(); // remove leading zero
            }

            if (stack.isEmpty()) { // all zero
                return new int[] {0};
            }

            int[] ans = new int[stack.size()];
            int index = 0;
            while (!stack.isEmpty()) {
                ans[index++] = stack.pop();
            }
            return ans;
        }
    }
```
