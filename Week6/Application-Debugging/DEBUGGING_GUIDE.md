# Application Debugging – Week 6

## React with Chrome DevTools
1. Run an application using `npm run hol -- 1`.
2. Open `http://localhost:5173` and press `F12`.
3. Use **Elements** to inspect the DOM and CSS.
4. Use **Sources** to place breakpoints in `src/App.jsx`; Vite provides source maps.
5. Use **Network** for HOL 4, 17 and 19 to inspect API requests and responses.
6. Use **Console** for runtime errors and React Developer Tools for props and state.

## Angular with Chrome DevTools
1. Open the Angular project and run `ng serve` or `npm start`.
2. Open `http://localhost:4200` and press `F12`.
3. Use the **Sources** panel to find TypeScript files through source maps.
4. Add breakpoints in components, services, guards or NgRx effects.
5. Use **Network** to inspect HttpClient requests and interceptor behaviour.

## VS Code debugging
1. Start the React or Angular development server.
2. Open **Run and Debug** in VS Code.
3. Select the matching launch configuration from `.vscode/launch.json`.
4. Place breakpoints in a source file and refresh the browser.
5. Inspect the call stack, variables, watches and breakpoints panels.

## Common problems
- A blank page usually means a browser-console JavaScript error.
- `ENOENT package.json` means the terminal is in the wrong directory or the root `package.json` is missing.
- Port already in use: use another port, such as `npm start -- --port 5174` for Vite.
- API fails but the UI builds: check the Network tab, CORS and the endpoint URL.
- Dependency installation is corrupted: delete `node_modules` and run `npm install` again.
