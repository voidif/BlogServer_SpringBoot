var webpack = require("webpack");
var path = require("path");

var SRC = path.resolve(__dirname, "src");
var OUTPUT = path.resolve(__dirname, "output");

module.exports = {
  entry: SRC + "/index.jsx",
  output: {
    path: OUTPUT,
    filename: "index.js"
  },
  module: {
    rules: [
      {
        include: SRC,
        use: [{ loader: 'babel-loader' }],
      }
    ]
  },
  resolve: {
    modules: [
        path.resolve("./src"),
        path.resolve("./node_modules")
    ],
    extensions: [".js", ".jsx"]
  },
  mode: 'development'
};
