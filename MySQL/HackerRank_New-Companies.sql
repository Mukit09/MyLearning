select tmp.company_code, tmp.founder, (
    select count(distinct lead_manager_code) from Lead_Manager where tmp.company_code = Lead_Manager.company_code
), (
    select count(distinct senior_manager_code) from Senior_Manager where tmp.company_code = Senior_Manager.company_code
), (
    select count(distinct manager_code) from Manager where tmp.company_code = Manager.company_code
), (
    select count(distinct employee_code) from Employee where tmp.company_code = Employee.company_code
) from Company as tmp
    order by tmp.company_code;