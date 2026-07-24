import { Component } from 'react';

class Home extends Component {
  render() {
    return <section className="card"><h2>Home</h2><p>Welcome to the Home page of Student Management Portal</p></section>;
  }
}
class About extends Component {
  render() {
    return <section className="card"><h2>About</h2><p>Welcome to the About page of the Student Management Portal</p></section>;
  }
}
class Contact extends Component {
  render() {
    return <section className="card"><h2>Contact</h2><p>Welcome to the Contact page of the Student Management Portal</p></section>;
  }
}
export default class App extends Component {
  render() {
    return <main><h1>Student Management Portal</h1><div className="grid"><Home/><About/><Contact/></div></main>;
  }
}
