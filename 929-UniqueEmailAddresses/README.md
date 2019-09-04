Every email consists of a local name and a domain name, separated by the @ sign.

For example, in `alice@leetcode.com`, `alice` is the local name, and `leetcode.com` is the domain name.

Besides lowercase letters, these emails may contain `'.'`s or `'+'`s.

If you add periods (`'.'`) between some characters in the **local name** part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, `"alice.z@leetcode.com"` and `"alicez@leetcode.com"` forward to the same email address.  (Note that this rule does not apply for domain names.)

If you add a plus (`'+'`) in the **local name**, everything after the first plus sign will be **ignored**. This allows certain emails to be filtered, for example `m.y+name@email.com` will be forwarded to `my@email.com`.  (Again, this rule does not apply for domain names.)

It is possible to use both of these rules at the same time.

Given a list of `emails`, we send one email to each address in the list.  How many different addresses actually receive mails? 

---

> Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
> Output: 2
> Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails

---

For each email address, convert it to the *canonical* address that actually receives the mail. This involves a few steps:

- Separate the email address into a `local` part and the `rest` of the address.
- If the `local` part has a `'+'` character, remove it and everything beyond it from the `local` part.
- Remove all the zeros from the `local` part.
- The canonical address is `local + rest`.

After, we can count the number of unique canonical addresses with a `Set`structure.

```java
class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> seen = new HashSet();
        for (String email: emails) {
            int i = email.indexOf('@');
            String local = email.substring(0, i);
            String rest = email.substring(i);
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }
            local = local.replaceAll("\\.", "");
            seen.add(local + rest);
        }

        return seen.size();
    }
}
```

- Time Complexity: O(C), whereC is the total content of `emails`.
- Space Complexity: O(C). 