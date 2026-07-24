import { Component } from 'react';

class Cart {
  constructor(itemname, price) {
    this.itemname = itemname;
    this.price = price;
  }
}

class OnlineShopping extends Component {
  constructor(props) {
    super(props);
    this.items = [
      new Cart('Laptop', 65000),
      new Cart('Mobile', 25000),
      new Cart('Headphones', 3000),
      new Cart('Keyboard', 1500),
      new Cart('Mouse', 800)
    ];
  }
  render() {
    return <table><thead><tr><th>Item</th><th>Price</th></tr></thead><tbody>
      {this.items.map(item => <tr key={item.itemname}><td>{item.itemname}</td><td>₹{item.price}</td></tr>)}
    </tbody></table>;
  }
}

export default function App() {
  return <main><h1>Online Shopping</h1><OnlineShopping/></main>;
}
