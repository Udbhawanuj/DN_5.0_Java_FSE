import { useContext } from 'react';
import ThemeContext from './ThemeContext';

export default function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);
  return <article className={`card ${theme}`}><h3>{employee.name}</h3><p>{employee.role}</p><button className={theme}>View</button></article>;
}
