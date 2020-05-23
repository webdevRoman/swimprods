const path = require('path');
const VueLoaderPlugin = require('vue-loader/lib/plugin');

module.exports = {
  mode: 'development',
  devtool: 'source-map',
  entry: path.join(__dirname, 'src', 'main', 'resources', 'static', 'js', 'main.js'),
  devServer: {
    contentBase: './dist',
    compress: true,
    port: 8000,
    allowedHosts: [
      'localhost:8080'
    ]
  },
  module: {
    rules: [
      {
        test: /\.pug$/,
        loader: 'pug-plain-loader'
      },
      {
        test: /\.styl(us)?$/,
        use: [
          'vue-style-loader',
          'css-loader',
          'stylus-loader'
        ]
      },
      {
        test: /\.(png|jpe?g|gif|svg)$/i,
        exclude: /node_modules/,
        loader: 'file-loader',
        options: {
          // name: '[path][name].[ext]',
          name: '[name].[ext]',
          esModule: false,
          publicPath: 'dist',
          // outputPath: 'src/main/resources/static/assets/img/'
        }
      },
      // {
      //   test: /\.(png|jpe?g|gif|svg)$/i,
      //   exclude: /node_modules/,
      //   loader: 'url-loader',
      //   options: {
      //     // name: '[path][name].[ext]',
      //     // name: '[name].[ext]',
      //     esModule: false,
      //     // outputPath: 'src/main/resources/static/assets/img/'
      //   }
      // },
      {
        test: /\.js$/,
        exclude: /(node_modules|bower_components)/,
        use: {
          loader: 'babel-loader',
          options: {
            presets: ['@babel/preset-env']
          }
        }
      },
      {
        test: /\.vue$/,
        loader: 'vue-loader'
      }
    ]
  },
  plugins: [
    new VueLoaderPlugin()
  ],
  resolve: {
    modules: [
      path.join(__dirname, 'src', 'main', 'resources', 'static', 'js'),
      path.join(__dirname, 'node_modules'),
    ],
  }
};