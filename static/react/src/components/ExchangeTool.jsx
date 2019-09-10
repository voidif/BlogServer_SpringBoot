import React from 'react';

class ExchangeTool extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            USD_CNY: 0
        };
        this.getRate();
    }

    render() {
        const divStyle = {
            backgroundColor: '#ffd04f'
        };
        const rate = this.state.USD_CNY;
        return (
            <div className="toolbox" style={divStyle}>
                <h1 className="tooltitle">Get Exchange Rate(USD to CNY)</h1>
                <p>Rate: (Data refreshs every ten minutes)</p>
                <p id="rate">{rate}</p>
                <p id="time">{new Date().toLocaleTimeString()}</p>
                <center><button type="button" id="getRate" className="btn btn-default">Get Rate Now!</button></center>
            </div>
        );
    }

    getRate() {
        fetch("/api/rate?currencyPairName=USD_CNY")
        .then(function(response) {
            return response.json();
        })
        .then((myJson) => {
            this.setState({
                USD_CNY: myJson.rate
            });
        });
    }
}

export default ExchangeTool;