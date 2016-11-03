Objects:
- ATM
- Person (User)
- Card
- Account
- Security
- Transaction History
- Bill
- Money

=====================================================

1. PERSON inserts a CARD into the ATM

2. ATM (SECURITY) validates the CARD:
   - is CARD correctly inserted;
   - accepts that TYPE of the CARD;
   
3. ATM asks to enter a pincode:
   - checks correctness of the pincode;
   - is not expired;
   
4. PERSON chooses a function:
   - check ACCOUNT (money on the screen, on a bill);
   - money transfer;
   - mobile payments;
   
5. Get money from ATM:
   - PERSON enters amount of MONEY;
   - ATM (SECURITY) checks if it is enough money on ACCOUNT;
   - ATM checks if it has enough money;
   - ATM updates PERSON's ACCOUNT;
   
6. ATM returns a CARD to a PERSON

7. ATM updates HISTORY of operations

8. Print a BILL:
   - if PERSON wants a BILL
