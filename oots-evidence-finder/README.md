# OOTS EVIDENCE FINDER

Umožňuje vyhľadávať procedúry, požiadavky, typy dôkazov a poskytovateľov registrovaných pre konkrétne krajiny európskej únie.

## Dokumentácia

- [Inštalácia](INSTALL.md)
- [Špecifikácia API](https://generator3.swagger.io/index.html?url=https://raw.githubusercontent.com/slovak-egov/oots-poc/main/swagger/evidenceFinder.json)

## Príklad použitia

1. Vyberiem krajinu z ktorej chcem získať dôkaz (napr. SK)
   - /commonservices/eb/lookup/countryCodes
3. Vyberiem procedúru pre ktorú chcem získať dôkaz (napr. T1 - Applying for a tertiary education study financing, such as study grants and loans from a public body or institution)
   - /commonservices/eb/lookup/procedureTypes/SK
5. Vyberiem požiadavku pre ktorú chcem získať dôkaz (napr. https://sr.oots.tech.ec.europa.eu/requirements/9196feb5-a88f-488d-8aad-7842cf64d1ac - Proof of secondary education diploma/certificate)
   - /commonservices/eb/lookup/requirements/SK/T1
7. Vyberiem typ dôkazu ktorý chcem získať (napr. https://sr.oots.tech.ec.europa.eu/evidencetypeclassifications/EU/c10047cd-f02b-4cf2-b337-de2a0d24ce4f - EU-Wide Secondary School Education completion)
   - /commonservices/eb/lookup/evidenceTypes/SK?requirementId=https://sr.oots.tech.ec.europa.eu/requirements/9196feb5-a88f-488d-8aad-7842cf64d1ac
9. Vyberiem poskytovateľa pre vybraný typ dôkazu (napr. sk_test_ap - SK Ministry of the Projectathon)
   - /commonservices/dsd/lookup/dataServices/SK?evidenceType=https://sr.oots.tech.ec.europa.eu/evidencetypeclassifications/EU/c10047cd-f02b-4cf2-b337-de2a0d24ce4f
