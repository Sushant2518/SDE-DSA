# String vs StringBuilder vs char[]

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
I have two strings, word1 and word2. I need to merge these two strings alternately and return the result as a string. The merged string should always start with the first character of word1. I also need to handle the case where one string is longer than the other by appending its remaining characters to the end of the merged string.

# Approach 1
<!-- Describe your approach to solving the problem. -->
Initially, I thought of creating an empty string and using a single pointer initialized to 0. Then, I would iterate through both strings simultaneously and, using conditional checks, concatenate characters from each string alternately to build the final merged string.

**Steps** 
1. Create an empty string to store the merged strings. (String ans = "")  
2. Declare and initialize a pointer i with the value 0 (int i = 0).
3. Iterate the pointer i through both strings, starting from index 0 until all characters in both strings have been processed.
4. During each iteration, check whether the current index exists in each string:
    - If the current index exists in word1, concatenate word1.charAt(i) with the ans.
    - If the current index exists in word2, concatenate word2.charAt(i) to the ans.
5. Increment the pointer i.
6. Return the merged string.

## Code for approach 1
```
class Solution {
    public String mergeAlternately(String word1, String word2) {
        String ans = "";
        int i = 0;

        while(i<=word1.length()-1 || i<=word2.length()-1){
            if(i<=word1.length()-1){
                ans+=word1.charAt(i);
            }

            if(i<=word2.length()-1){
                ans+=word2.charAt(i);
            }
            i++;
        }
        return ans;
    }
}
```

**Dry Run**
1. i = 0 
    - Add from word1 -> a -> ans = a
    - Add from word2 -> p -> ans = ap
2. i = 1 
    - Add from word1 -> b -> ans = apb
    - Add from word2 -> q -> ans = apbq
3. i = 2
    - Add from word1 -> c -> ans = apbqc
    - Add from word2 -> r -> ans = apbqcr

4. return -> apbqcr


### Complexity
**Time complexity:**
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
I know that Java Strings are immutable, which means that once a String is created, it cannot be modified. Every time I perform ans += character, a new String is created, and all the characters from the previous string are copied into it before appending the new character.

Let `m` and `n` be the lengths of `word1` and `word2`, respectively. The final merged string has a length of **`m + n`**. Due to the repeated copying during each concatenation, the overall time complexity becomes **`O((m + n)²)`**.

The algorithm uses `O(m + n)` space to store the final merged string (excluding the temporary strings created during concatenation).

This approach is considered brute force because it directly constructs the result using repeated string concatenation without optimizing for the cost of creating new strings. Although it is simple and correct, it is inefficient for large inputs because of the repeated copying overhead.

**Space complexity:**
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
`O(m+n)` (excluding temporary strings, the final output stores `m+n` characters)

### String concatenation in Java depends on where it happens
#### Case 1: Using the `+` operator inside a single expression
```
String s = "Hello" + " " + "World";
```
The compiler transforms it roughly into:
```
String s = new StringBuilder()
                .append("Hello")
                .append(" ")
                .append("World")
                .toString();
```
So Java does not concatenate Strings directly. It uses a `StringBuilder` behind the scenes.

#### Case 2: Using `+=` repeatedly (inside a loop)
Consider:
```
String ans = "";

for (char c : chars) {
    ans += c;
}
```
So here Java does not extending the same String. Each iteration is approximately transformed into:
```
ans = new StringBuilder()
          .append(ans)
          .append(c)
          .toString();
```
Notice that a new `StringBuilder` is created every iteration.
**Iteration 1**
```
ans = "";
ans += 'a';
```
Equivalent to:

```
StringBuilder sb = new StringBuilder();
sb.append("");
sb.append('a');
ans = sb.toString();
```
Result :

```
ans = "a"
```
**Iteration 2**
```
ans += 'b';
```

Equivalent to :

```
StringBuilder sb = new StringBuilder();

sb.append("a");
sb.append('b');

ans = sb.toString();
```

Result :

```
ans = "ab"
```

Notice:

```
Create new StringBuilder
Copy "a"
Append 'b'
Create new String "ab"
```
**Iteration 3**
```
ans += 'c';
```
Equivalent to :

```
StringBuilder sb = new StringBuilder();

sb.append("ab");
sb.append('c');

ans = sb.toString();

```
Result :
```

ans = "abc"
```

Again,

```
Create new StringBuilder
Copy "ab"
Append 'c'
Create new String "abc"
```
### StringBuilder in Java

#### What is StringBuilder?

`StringBuilder` is a **mutable sequence of characters**.

- **String** → Immutable (cannot be changed after creation)
- **StringBuilder** → Mutable (can be modified after creation)

Unlike `String`, which creates a new object every time during concatenation, `StringBuilder` updates its internal storage without creating a new object for each modification.

---

#### How does StringBuilder work internally?

Suppose you create a `StringBuilder`:

```java
StringBuilder sb = new StringBuilder();
```

Internally, Java creates an array similar to:

```java
char[] value = new char[16];
```

The **default capacity** is **16 characters**.

#### Initial State

```text
Index

0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15

[_ _ _ _ _ _ _ _ _ _  _  _  _  _  _  _]

length = 0
capacity = 16
```

#### Notice

- No characters have been added yet.
- Capacity = **16**
- Length (current size) = **0**

---

#### Append the First Character

```java
sb.append('a');
```

Internal Array

```text
[a _ _ _ _ _ _ _ _ _ _ _ _ _ _ _]

length = 1
capacity = 16
```

No new array is created.

The character is simply placed in the next available position.

---

#### Append the Second Character

```java
sb.append('b');
```

Internal Array

```text
[a b _ _ _ _ _ _ _ _ _ _ _ _ _ _]

length = 2
capacity = 16
```

Again,

- No copying
- No new object
- No new array

---

#### Append the Third Character

```java
sb.append('c');
```

Internal Array

```text
[a b c _ _ _ _ _ _ _ _ _ _ _ _ _]

length = 3
capacity = 16
```

The same internal array is reused.

---

#### What Happens When the Array Becomes Full?

Suppose the capacity is only **4**.

```text
[a b c d]

length = 4
capacity = 4
```

Now,

```java
sb.append('e');
```

There is no available space.

Java creates a **larger internal array**.

The new capacity is approximately calculated as:

```java
newCapacity = oldCapacity * 2 + 2
```

#### Example

Old Array

```text
[a b c d]
```

New Array

```text
[a b c d _ _ _ _ _ _]
```

The existing characters are copied **only once** during resizing.

After appending `'e'`:

```text
[a b c d e _ _ _ _ _]

length = 5
capacity = 10
```

---

#### Why is `append()` O(1)?

A common question is:

> **"If resizing requires copying all elements, shouldn't `append()` be O(n)?"**

Sometimes, yes.

However, **most of the time it is not**.

Consider a `StringBuilder` with a capacity of **16**.

```text
Append 1

[a]

Append 2

[a b]

Append 3

[a b c]

...

Append 16

[a b c ...]
```

During these 16 appends:

- No resizing occurs.
- No copying occurs.

Only when appending the **17th** character does Java resize the array.

```text
append()
append()
append()
append()
append()
append()
resize once
append()
append()
append()
```

Since resizing happens **rarely**, the average cost of each `append()` operation remains constant.

This is known as **constant O(1)** time complexity.

---

#### When `toString()` Used?

`StringBuilder` stores characters in a mutable internal `char[]`. Calling `append()` **does not** create a `String`.

```java
StringBuilder sb = new StringBuilder();

sb.append("Hello");
sb.append(" World");
```
At this point, sb is still a StringBuilder.
```
StringBuilder

[H e l l o   W o r l d _ _ _ _]
```
No String object has been created yet.

A String is created only when you explicitly call toString() or when a String is required.
```
String result = sb.toString();
```
Internally:
```
StringBuilder

[H e l l o   W o r l d]

        │
        ▼
   toString()

        ▼

String

"Hello World"
```
After calling toString():

- A new immutable String object is created.
- The original StringBuilder still exists and can continue to be modified.

```
sb.append("!");

System.out.println(result); // Hello World
System.out.println(sb);     // Hello World!
```
> Note: When using the + or += operator with String, the Java compiler internally creates a temporary StringBuilder, performs the append() operations, and automatically calls toString() because the final result must be a String. However, when you use StringBuilder directly, Java does not call toString() automatically—you decide when to convert it into a String.
---

#### Why is StringBuilder Faster than String?

##### Using String

```java
String s = "";

s += 'a';
s += 'b';
s += 'c';
```

Each concatenation creates:

- A new compiler-generated `StringBuilder`
- A new internal `char[]`
- A new `String`

This process repeats for every concatenation.

---

##### Using StringBuilder

```java
StringBuilder sb = new StringBuilder();

sb.append('a');
sb.append('b');
sb.append('c');

String result = sb.toString();
```

This approach creates only:

- One `StringBuilder`
- One internal `char[]` (until resizing is required)
- One final immutable `String` when `toString()` is called

---

#### Key Takeaways

- `StringBuilder` internally uses a **resizable `char[]`**.
- Characters are appended directly to the existing array.
- A new array is allocated **only when the current one becomes full**.
- Resizing happens infrequently, so `append()` runs in **constant O(1)** time.
- Calling `toString()` explicitly converts the mutable `StringBuilder` into an immutable `String`. It is only required when you need a `String` object.
- For repeated string modifications, `StringBuilder` is significantly more efficient than using `String` concatenation (`+` or `+=`).

# Approach 2
<!-- Describe your approach to solving the problem. -->
If I use StringBuilder instead of String concatenation (+=), the logic remains the same, but unnecessary string copying is avoided.

**Steps** 
1. create a `StringBuilder` to store the merged result.
2. Declare and initialize a pointer i with the value 0 (int i = 0).
3. Iterate the pointer i through both strings, starting from index 0 until all characters in both strings have been processed.
4. During each iteration, check whether the current index exists in each string:
    - If the current index exists in word1, concatenate word1.charAt(i) with the ans.
    - If the current index exists in word2, concatenate word2.charAt(i) to the ans.
5. Increment the pointer i.
6. Return the merged string.

## Code for approach 2
```
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        int i = 0;

        while(i<=word1.length()-1 || i<=word2.length()-1){
            if(i<=word1.length()-1){
                ans.append(word1.charAt(i));
            }

            if(i<=word2.length()-1){
                ans.append(word2.charAt(i));
            }
            i++;
        }
        return ans.toSting();
    }
}
```

**Dry Run**
1. i = 0 
    - Add from word1 -> a -> ans = a
    - Add from word2 -> p -> ans = ap
2. i = 1 
    - Add from word1 -> b -> ans = apb
    - Add from word2 -> q -> ans = apbq
3. i = 2
    - Add from word1 -> c -> ans = apbqc
    - Add from word2 -> r -> ans = apbqcr

4. return -> apbqcr


### Complexity
**Time complexity:** O(m + n)

StringBuilder maintains a resizable character array internally.

Instead of creating a new string every time:

```
append('a')
append('b')
append('c')
append('d')
```

it simply writes into the next available position:

```
[a][b][c][d]
```

Each append() is O(1) on average (constant time).

Since each character from word1 and word2 is appended exactly once:

```
m + n appends

where:

m = word1.length()
n = word2.length()
```

Therefore, Time Complexity: O(m + n)


**Space complexity:** O(m + n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Approach 3: Using `char[]`

## Code for approach 3
```
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        int i = 0;

        while(i<=word1.length()-1 || i<=word2.length()-1){
            if(i<=word1.length()-1){
                ans.append(word1.charAt(i));
            }

            if(i<=word2.length()-1){
                ans.append(word2.charAt(i));
            }
            i++;
        }
        return ans.toSting();
    }
}
```


## Why use `char[]`?

In this problem, we already know the exact size of the final merged string.

```java
word1.length() + word2.length()
```

Instead of using a `String` or `StringBuilder`, we can directly create a character array of the required size.

```java
char[] ans = new char[word1.length() + word2.length()];
```

This avoids:

- Repeated string creation (`String`)
- Dynamic resizing (`StringBuilder`)

---

## How does it work?

Suppose:

```java
word1 = "abc";
word2 = "pq";
```

The final merged string will contain:

```text
3 + 2 = 5 characters
```

So we create:

```java
char[] ans = new char[5];
```

Initially:

```text
Index

0 1 2 3 4

[_ _ _ _ _]
```

---

### Step 1

```java
ans[k] = word1.charAt(i);
```

```text
[a _ _ _ _]
```

---

### Step 2

```java
ans[k] = word2.charAt(i);
```

```text
[a p _ _ _]
```

---

### Step 3

```java
ans[k] = word1.charAt(i);
```

```text
[a p b _ _]
```

---

### Step 4

```java
ans[k] = word2.charAt(i);
```

```text
[a p b q _]
```

---

### Step 5

```java
ans[k] = word1.charAt(i);
```

```text
[a p b q c]
```

Now every position in the array has been filled.

---

## Why is this efficient?

The character array is created only once.

```java
char[] ans = new char[m + n];
```

Each character is written directly into its correct position.

```java
ans[k++] = word1.charAt(i);
ans[k++] = word2.charAt(i);
```

There is:

- No resizing
- No repeated copying
- No creation of intermediate `String` objects

Each character is written exactly once.

---

## Why do we use `String.valueOf(ans)`?

The method must return a `String`.

However, `ans` is a `char[]`.

```java
char[] ans = {'a', 'p', 'b', 'q', 'c'};
```

To convert the character array into a `String`, we use:

```java
return String.valueOf(ans);
```

Internally, Java creates one final immutable `String` from the character array.

```text
char[]

[a p b q c]

        │
        ▼

String.valueOf(ans)

        │
        ▼

String

"apbqc"
```

This conversion happens only once, after all characters have been placed into the array.

---

## Complexity

- **Time Complexity:** `O(m + n)`

  Each character from `word1` and `word2` is copied exactly once into the character array.

- **Space Complexity:** `O(m + n)`

  A character array of size `m + n` is allocated to store the merged string.

---

## Why is this more optimal than `StringBuilder`?

Both approaches have the same time complexity, **O(m + n)**.

However, `char[]` is slightly more efficient because:

- The exact memory is allocated once.
- No capacity checks are required.
- No dynamic resizing is needed.
- Characters are written directly into the array.

When the final size of the result is known in advance, using a `char[]` is generally the most efficient approach.

### Why Doesn't `char[]` Use `toString()`?

#### Understanding the Difference

The reason is based on the **type of the object**.

Consider the following code:

```java
char[] ans = new char[word1.length() + word2.length()];
```

Here, `ans` is a **character array (`char[]`)**, **not** a `StringBuilder`.

---

#### Why Can't We Write `ans.toString()`?

Technically, you **can** write:

```java
ans.toString();
```

because every array in Java inherits the `toString()` method from the `Object` class.

However, **it does not convert the character array into a string**.

##### Example

```java
char[] arr = {'H', 'e', 'l', 'l', 'o'};

System.out.println(arr.toString());
```

##### Output

```text
[C@5acf9800
```

or something similar:

```text
[C@3fee733d
```

---

#### Why Does This Happen?

The `toString()` method inherited from `Object` returns:

```text
ClassName@HexadecimalHashCode
```

For a `char[]`:

- `[C` → Represents an **array of characters (`char[]`)**
- `@3fee733d` → The object's hash code in hexadecimal

So,

```java
arr.toString();
```

does **not** print the contents of the array.

---

#### Then Why Does `String.valueOf(ans)` Work?

The `String` class provides a special overloaded method for character arrays:

```java
public static String valueOf(char[] data)
```

Internally, it is roughly equivalent to:

```java
return new String(data);
```

##### Example

```java
char[] ans = {'a', 'p', 'b', 'q', 'c'};
```

```java
String.valueOf(ans);
```

##### Output

```text
"apbqc"
```

This method reads every character from the array and creates a new immutable `String`.

---

### Why Does `StringBuilder` Have `toString()`?

Unlike arrays, `StringBuilder` **defines its own implementation** of `toString()`.

```java
public String toString()
```

This method converts its internal `char[]` into a `String`.

##### Example

```java
StringBuilder sb = new StringBuilder();

sb.append("Hello");

sb.toString();
```

This works because `StringBuilder` **overrides** the `toString()` method inherited from `Object`.

---

##### Comparison

## `char[]`

```java
char[] arr = {'H', 'i'};

arr.toString();          // ❌ [C@36baf30c
String.valueOf(arr);     // ✅ "Hi"
new String(arr);         // ✅ "Hi"
```

---

## `StringBuilder`

```java
StringBuilder sb = new StringBuilder("Hi");

sb.toString();           // ✅ "Hi"
```

---

### Why `String.valueOf()` Instead of `new String()`?

Both approaches work.

```java
return new String(ans);
```

and

```java
return String.valueOf(ans);
```

produce the same result.

`String.valueOf(char[])` internally creates a `String` from the character array, so both approaches are effectively equivalent.

---

> `toString()` is not suitable for a `char[]` because arrays inherit `toString()` from `Object`, which returns the object's class name and hash code instead of its contents. `String.valueOf(char[])` (or `new String(char[])`) is specifically designed to convert a character array into a `String`.
