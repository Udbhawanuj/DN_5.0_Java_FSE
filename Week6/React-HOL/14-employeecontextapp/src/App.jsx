import { useState } from 'react';
import ThemeContext from './ThemeContext';
import EmployeesList from './EmployeesList';

export default function App() {
  const [theme, setTheme] = useState('light');
  return <ThemeContext.Provider value={theme}>
    <main className={theme}>
      <h1>Employee Management</h1>
      <button onClick={() => setTheme(value => value === 'light' ? 'dark' : 'light')}>Switch Theme</button>
      <EmployeesList/>
    </main>
  </ThemeContext.Provider>;
}
