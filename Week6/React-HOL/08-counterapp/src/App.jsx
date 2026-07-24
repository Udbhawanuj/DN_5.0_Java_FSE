import { Component } from 'react';

class CountPeople extends Component {
  constructor(props) {
    super(props);
    this.state = { entrycount: 0, exitcount: 0 };
    this.updateEntry = this.updateEntry.bind(this);
    this.updateExit = this.updateExit.bind(this);
  }
  updateEntry() {
    this.setState(state => ({ entrycount: state.entrycount + 1 }));
  }
  updateExit() {
    this.setState(state => ({ exitcount: state.exitcount + 1 }));
  }
  render() {
    return <div className="card">
      <button onClick={this.updateEntry}>Login</button><span> People Entered: {this.state.entrycount}</span><br/>
      <button onClick={this.updateExit}>Exit</button><span> People Exited: {this.state.exitcount}</span>
    </div>;
  }
}

export default function App() {
  return <main><h1>Mall Counter</h1><CountPeople/></main>;
}
