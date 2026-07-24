import { Component } from 'react';

class Post {
  constructor(id, title, body) {
    this.id = id;
    this.title = title;
    this.body = body;
  }
}

class PostList extends Component {
  render() {
    return <div className="grid">{this.props.posts.map(post => (
      <article className="card" key={post.id}><h3>{post.title}</h3><p>{post.body}</p></article>
    ))}</div>;
  }
}

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = { posts: [], error: '', loading: true };
  }

  async loadPosts() {
    try {
      const response = await fetch('https://jsonplaceholder.typicode.com/posts?_limit=10');
      if (!response.ok) throw new Error('Unable to load posts');
      const data = await response.json();
      this.setState({ posts: data.map(item => new Post(item.id, item.title, item.body)), loading: false });
    } catch (error) {
      this.setState({ error: error.message, loading: false });
    }
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error) {
    this.setState({ error: error.message, loading: false });
  }

  render() {
    if (this.state.loading) return <p>Loading posts...</p>;
    if (this.state.error) return <p className="error">{this.state.error}</p>;
    return <PostList posts={this.state.posts}/>;
  }
}

export default function App() {
  return <main><h1>Blog Posts</h1><Posts/></main>;
}
