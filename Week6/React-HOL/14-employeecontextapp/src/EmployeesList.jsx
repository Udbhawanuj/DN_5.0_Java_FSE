import EmployeeCard from './EmployeeCard';
const employees = [{ id: 1, name: 'Udbhaw', role: 'Developer' }, { id: 2, name: 'Priya', role: 'Tester' }];
export default function EmployeesList() {
  return <div className="grid">{employees.map(employee => <EmployeeCard key={employee.id} employee={employee}/>)}</div>;
}
