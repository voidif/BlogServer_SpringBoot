import React from 'react';
import Introduce from './Introduce'
import Tools from './Tools'

class IndexPage extends React.Component {
    render() {
        return (
            <div>
                <div className="col-md-8">
                    <Introduce/>
                </div>
                <div className="col-md-4">
                    <Tools/>
                </div>
            </div>
        );
    }
}

export default IndexPage;