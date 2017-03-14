DELETE FROM autoclaim;

INSERT INTO autoclaim(
            id, claimstatus, contactnumber, driver, email, incidentdate, 
            incidenttype, make, model, payments, policynumber, policytype, 
            reporteddate, vin, year)
    VALUES (20174561, 'Pending', '9824571556', 'John', 'john.smith@gmail.com', '01/01/2017', 
            'accident', 'Ford', 'Feista', 'DIRECT', 'kdfjhsdki748564', 'Standard', 
            '03/01/2017', '123456', '2010');
