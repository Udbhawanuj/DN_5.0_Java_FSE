SET SERVEROUTPUT ON;
PROMPT Scenario 1: Apply 1% interest discount for customers above 60 years old
BEGIN
    FOR rec IN (
        SELECT l.LoanID, c.Name, l.InterestRate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE MONTHS_BETWEEN(SYSDATE, c.DOB) / 12 > 60
    ) LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = rec.LoanID;
        DBMS_OUTPUT.PUT_LINE('Discount applied for ' || rec.Name || ', Loan ID: ' || rec.LoanID);
    END LOOP;
END;
/
PROMPT Scenario 2: Mark customers as VIP if balance is greater than 10000

BEGIN
    FOR rec IN (SELECT CustomerID, Name, Balance FROM Customers) LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE(rec.Name || ' marked as VIP.');
        END IF;
    END LOOP;
END;
/
PROMPT Scenario 3: Print reminders for loans due within next 30 days

BEGIN
    FOR rec IN (
        SELECT c.Name, l.LoanID, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || rec.LoanID || ' for ' || rec.Name || ' is due on ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY'));
    END LOOP;
END;
/
COMMIT;