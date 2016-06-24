var webpack = require('webpack');
var HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  //Good for debug, it keep's the reference of the original source.
  devtool: 'source-map',
  entry: __dirname+"/app/Viewport.js",
  output: {
    path: __dirname+"/public",
    filename: "bundle.js"
  },
  module: {
    loaders: [
      {test: /\.css$/, loader: "style!css?"},
      {
        test: /\.js$/,
        exclude: /node_modules/,
        loader: 'babel'
      }
    ]
  },
  devServer: {
    contentBase: "./public",
    colors: true,
    historyApiFallback: true,
    inline: true,
    // hot: true
  },
  // postcss: [
    // require('autoprefixer')
  // ],
  plugins: [
    //Add this text to the top of the genereted file
    new webpack.BannerPlugin("Copyright Flying Unicorns inc."),
    new HtmlWebpackPlugin({
      template: __dirname + "/app/index.tmpl.html"
    })
    // new webpack.HotModuleReplacementPlugin()
  ]
};
